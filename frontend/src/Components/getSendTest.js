import './getSendTest.css'; //import CSS

// Simple POST request with a JSON body using fetch
function postTest(){
    
    var nameBoxVal = document.getElementById("nameBox").value;
    
    fetch('http://localhost:8080/api/v1/customer',
    { method: 'post',
        headers: { "Content-Type": "application/json"} ,
        body: JSON.stringify({name: nameBoxVal})
        }).then(() => {
            console.log('new Customer added')
        }) 
}
//simple get reqeust
function getTest(){
    
  // eslint-disable-next-line
    var resultsBox = 

    fetch('http://localhost:8080/api/v1/customer')
  .then(response => response.json()) //turn results to json format
  .then(data => document.getElementById("resultsBox").value = data[0].id) //output first result to text box
}

//Function that returns the HTML code
function getSendTest() {

    return (
      <div className="App">
        <h1>Hello World!</h1>
        <p>Basically, what I put together here is a couple test API's so you know how to model them. To test, type in a name, click post,
             then if you click get, you'll get back the ID that was generated. Must have Java application running localy for this to work.  </p>
        <input id="resultsBox" type="text" placeholder="ID"></input>
        <input id="nameBox" type="text" placeholder='Enter Name'></input>
        <br/>
        <br/>
        <button id="postTestButton" onClick={postTest}>Post</button>
        <button id="getTestButton" onClick={getTest}>Get</button>
      </div>
      
    );
  }
  
  export default getSendTest; //exports the function that returns the HTML to be imported wherever needed
  
