import React, {Component} from 'react';
import Layout from "./components/layout";
import ItemList from "./containers/itemlist";
import logo from "./logo.svg";
import './App.css';
import {BrowserRouter as Routes, Switch, Route} from "react-router-dom";
import Cart from "./containers/cartlist";

class App extends Component{
  render(){
    return(
      <Routes>
    <Switch>
        <Route exact path="/">
            <Layout>
                <ItemList/>
            </Layout>
        </Route>
        <Route exact path="/cart">
            <Layout>
                <Cart/>
            </Layout>
        </Route>
    </Switch>
</Routes>
    );
  }
}
export default App;
