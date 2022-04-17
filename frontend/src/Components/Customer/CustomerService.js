import { API_URL_BASE } from "../APIUrlBase";

const CUSTOMER_API = API_URL_BASE + "/customer/";

export async function getCustomerById(id) {
  return fetch(CUSTOMER_API + id)
    .then((res) => {
      return res.json();
    })
    .then((data) => {
      return data.json();
    });
}

export function setLoggedInCustomer(customer) {
    localStorage.setItem('user', JSON.stringify([]));
    let currentUser = JSON.parse(localStorage.getItem("user")) || [];
    currentUser.push(customer);
    localStorage.setItem('user', JSON.stringify(currentUser));
}

export function customerIsLoggedIn() {;
   return !(localStorage.getItem("user") === null);
}

export function currentLoggedInCustomer() {
  if (customerIsLoggedIn) {
    return JSON.parse(localStorage.getItem("user"));
  } else {
    return null;
  }
}

export function LogoutCustomer() {
  if (customerIsLoggedIn()) {
    localStorage.removeItem("user");
  }
}
