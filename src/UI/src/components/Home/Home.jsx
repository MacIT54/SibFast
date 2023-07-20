import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { filterByPrice } from "../../features/products/productsSlice";
import Poster from "../Poster/Poster";
import Products from "../Products/Products";
const Home = () => {
  const dispatch = useDispatch();
  const {
    products: {list},
  } = useSelector((state) => state);

  useEffect(() => {
    if (!list.length) return;

    dispatch(filterByPrice(1000));
  }, [dispatch, list.length]);
  return (
    <>
      <Poster />
      <Products/>
    </>
  );
};

export default Home;