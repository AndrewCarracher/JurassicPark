import React, { Component } from 'react';

class TransferDino extends Component {
  constructor(props){
    super(props)
  }

render(){
  return(
    <>
      <h4>Transfer Dino</h4>
      <p>Select Current Paddock</p>
      <select></select>
      <p>Select Dinosaur By Name</p>
      <select></select>
      <p>Select New Paddock</p>
      <select></select>
      <form>
        <input type="submit" value="Transfer Dinosaur" />
      </form>
    </>
  );
}
}

export default TransferDino;
