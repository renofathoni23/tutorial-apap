import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index"
import "./index.css";
import { Fab } from "@material-ui/core";
import  Badge  from "@material-ui/core/Badge";
import ShoppingCartIcon from  "@mui/icons-material/ShoppingCart"
import ViewStreamIcon from "@mui/icons-material/ViewStream"

export default class Home extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }
    render(){
        return(
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position:"fixed", top:25, right:25}}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            :<ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary">Your Balance <b>{this.state.balance}</b></p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemfromCart}
                                ></List>
                            </div>
                        ) :
                        <div className="col-sm">
                            <List
                                title="List Items"
                                items={this.state.shopItems}
                                onItemClick={this.handleAddItemtoCart}
                                isShopList={true}
                            ></List>
                        </div>}
                    </div>
                </div>
            </div>
        );
    }

    handleAddItemtoCart = (item) =>{
        // console.log(item.inCart)
        // console.log(item.isShopList)
        const newItems = [...this.state.cartItems]
        const newItem = {...item};
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if(this.state.balance-newItem.price >= 0){
            if(targetInd<0){
                this.state.balance -= newItem.price.toFixed(2)
                newItem.inCart = true;
                newItems.push(newItem);
                this.updateShopItem(newItem, true)
            }
            this.setState({cartItems: newItems});
        }
        else{
            alert("Balance not sufficient")
        }
        // console.log(this.state.cartItems)
        // console.log(newItem)
        // console.log(newItems)

    };

    handleDeleteItemfromCart = (item)=> {
        // console.log(item.inCart)
        // console.log(item.isShopList)
        // console.log(this.state.cartItems)
        // console.log(item.id)
        // console.log(this.state.cartItems[0].id == item.id)
        const tempId = item.id;
        for(let i=0;i<this.state.cartItems.length;i++){
            if(this.state.cartItems[i].id == item.id){
                this.state.balance += this.state.cartItems[i].price
                this.state.cartItems[i].inCart = false
                this.updateShopItem(this.state.cartItems[i], false)
                this.state.cartItems.splice(i,1)
                //console.log(this.state.cartItems)
                
             }
        }
    }


    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it)=> it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({shopItems: tempShopItems});
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({cartHidden: !cartHidden});
    }
}
