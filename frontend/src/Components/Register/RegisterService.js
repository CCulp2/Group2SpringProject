import { API_URL_BASE } from "../APIUrlBase";

const CUSTOMER_API = API_URL_BASE + '/customer/'

export async function addCustomer(values) {
    return fetch(CUSTOMER_API, {
    method: "post",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      username: values.username,
      password: values.password,
      firstName: values.first_name,
      lastName: values.last_name,
      address: values.address,
      city: values.city,
      state: values.state,
    })
    }).then((res) => {
        return res.json();
    })
}