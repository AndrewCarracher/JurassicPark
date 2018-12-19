import React, { Component } from 'react';
import AddDino from './dinosaur_view/add_dino';
import RemoveDino from './dinosaur_view/remove_dino';
import TransferDino from './dinosaur_view/transfer_dino';
import Request from '../helpers/request';

class DinosaurView extends Component {
  constructor(props){
    super(props)
    this.handleDinosaurSubmit = this.handleDinosaurSubmit.bind(this);
  }

  handleDinosaurSubmit(newDino){
    if(newDino){
      console.log(newDino);
      const request = new Request();
      let requestString = newDino.name + "/" + newDino.age + "/" +        newDino.species + "/" + newDino.fed + "/" + newDino.eatsMeat;

      request.post("/paddocks/add_new_dinosaur/" + requestString, newDino).then(() => {
        console.log(requestString);
        // window.location = "/paddocks"
      })
    }
  }

render(){
  return(
    <>
      <h2>Dinosaur View</h2>
      <AddDino handleDinosaurSubmit = {this.handleDinosaurSubmit}/>
      <RemoveDino />
      <TransferDino />
    </>
  );
}
}

export default DinosaurView;
