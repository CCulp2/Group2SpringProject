export function addToShoppingCart(item) {
    item.cartId = generateCartID()
    if (localStorage.getItem('cart') === null) {
        cartSetUp();
        let currentCart = JSON.parse(localStorage.getItem('cart')) || [];
        currentCart.push(item);
        localStorage.setItem('cart', JSON.stringify(currentCart));
    } else {
        let a = JSON.parse(localStorage.getItem('cart')) || [];
        a.push(item);
        localStorage.setItem('cart', JSON.stringify(a));
    }    
}

export function removeFromShoppingCart(cartIdToRemove) {
        let currentCart = JSON.parse(localStorage.getItem('cart'));
        let products = currentCart.filter(incartItem => incartItem.cartId !== cartIdToRemove);
        localStorage.setItem('cart', JSON.stringify(products));
}

export function getShoppingCartItems() {
    let a = JSON.parse(localStorage.getItem('cart')) || [];
    return a;
}

export function priceOfAllCartItems() {
    var sum = 0;    
    let cart = getShoppingCartItems();
    for (let i = 0; i < cart.length; i++) {
        sum += cart[i].unit_price;
    }
    return sum;
}

export function calculateTax(price) {
    let tax = 0.07;
    let sum =  Number(price) * Number(tax);
    if (isNaN(sum)) {
        return 0;
    }
    return sum;
}

export function pricePlusTax(price, tax) {
    let sum = price + tax;
    return sum;
}

export function formatDollarValues(value) {
    return formatter.format(value);
}

export function cartSetUp() {
    // let a = []
    // a.push(JSON.parse(localStorage.getItem('cart')));
    localStorage.setItem('cart', JSON.stringify([]));
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

function generateCartID() {
    let id = getRandomInt(300000);
    return id;
}

var formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2,
    maximumFractionDigits: 2
});

export function setTotals(currentCart) {
    let totals = {
        price: 0,
        tax: 0,
        total: 0,
      };
      totals.price = priceOfAllCartItems(currentCart);
      totals.tax = calculateTax(totals.price);
      totals.total = (Number(totals.price) + Number(totals.tax));
      totals.price = formatDollarValues(totals.price);
      totals.tax = formatDollarValues(totals.tax);
      totals.total = formatDollarValues(totals.total);
      return totals;
}