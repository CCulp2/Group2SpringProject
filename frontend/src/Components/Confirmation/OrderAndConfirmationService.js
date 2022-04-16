import { currentLoggedInCustomer } from "../Customer/CustomerService";
import { getShoppingCartItems, cartSetUp } from "../ShoppingCart/CartService";
import { API_URL_BASE } from '../../Components/APIUrlBase'

const ORDERS_API = API_URL_BASE + "/orders"

export async function submitOrder(cartOrder) {
    let orderToSend = prepareOrder(cartOrder);
    let result = await sendOrder(orderToSend);

    if (result === 0) {
        console.log("error");
    } else {
        return result;
    }
}

function prepareOrder() {
    let currentCustomer = currentLoggedInCustomer();
    let cart = getShoppingCartItems();
    removeCartIdBeforeOrder(cart);
    
    let order = {
        customerID: currentCustomer[0].id,
        productsToAdd: [...cart]
    }
    console.log(order);
    return order;
}

async function sendOrder(order) {
    const connection = await fetch(ORDERS_API, {
        method: 'post',
        headers: {"content-type": "application/json"},
        body: JSON.stringify(order)
    });

    const response = await connection.json();
    if (response.orderId !== null) {
        cartSetUp();
        console.log(response);
        return response;
    } else {
        console.log("Error.");
        return 0;
    }
}

function removeCartIdBeforeOrder(items) {
    let itemsForOrder = [...items]
    itemsForOrder.map(item => {
        return delete item.cartId;
    });
    return itemsForOrder;
}