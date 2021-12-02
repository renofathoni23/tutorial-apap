import React from "react";
import Button from "../button";
import classes from "./style.module.css";
const Item = (props) => {
    const { id, title, price, description, category, handleEdit, handleDelete, quantity} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
        </div>
    );
};
export default Item;
