import React, { Component } from "react";
import {Link} from 'react-router-dom'
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class Cart extends Component {
constructor(props) {
    super(props);
    this.state = {
    items: [],
    isLoading: false,
    id: "",
    title: "",
    price: 0,
    description: "",
    category: "",
    quantity: 0
    };
}


render() {
    console.log(this.state.items, "items")
    return (
    <div className={classes.itemList}>
    <h1 className={classes.title} style={ {position: "fixed", top: 10,left: 15} }>Cart Items</h1>
    <div style={ {position: "fixed", top: 75, left: 15} } >
        <Link to="/">
       
        <button>Back</button>
        </Link>
       
    </div>
    {
        this.state.items.length>0 &&
        <div style={ {position: "fixed", top: 25, right: 25} }>
        <button>Checkout</button>
    </div>
    }
    
    <div>
        {this.state.items.map((el) => (
        <Item
        key={el.id}
        id={el.id}
        title={el.item.title}
        totalQuantity={el.quantity}
        price={el.item.price}
        description={el.item.description}
        category={el.item.category}
        quantity={el.item.quantity}
        type={"cart"}
      
    />
))}
</div>

</div>

);
}

}

export default Cart;