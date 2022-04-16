export function storeJWT(response) {
    let parsedJSON = JSON.parse(response);
    localStorage.setItem('token', parsedJSON.access_token);
}

export function retrieveJWT() {
    return localStorage.getItem('token');
}