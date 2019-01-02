import React, { Component } from 'react';
import Request from '../../helpers/request';

class TransferDino extends Component {
  constructor(props){
    super(props)
    this.state = {
      dinosaurs: [],
      paddocks: [],
      paddockSelected: [],
      paddockSelectedName: [],
      dinoSelected: [],
      newPaddockSelected: [],
      id: []
    }
    this.handleDinoSelected = this.handleDinoSelected.bind(this);
    this.handlePaddockSelected = this.handlePaddockSelected.bind(this);
    this.handleNewPaddockSelected = this.handleNewPaddockSelected.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/dinosaurs/").then((data) => {
      this.setState({dinosaurs: data});
      })
    request.get("/paddocks/all").then((data) => {
      this.setState({paddocks: data});
      })
  }

  handleNewPaddockSelected(e){
    if(e){
      this.setState({newPaddockSelected: e.target.value});
    }
  }

  handlePaddockSelected(e){
    if(e){
      for(let i = 0; i< this.state.paddocks.length;  i++){
        if (this.state.paddocks[i].name === e.target.value){
          this.setState({paddockSelected: this.state.paddocks[i]});
          this.setState({paddockSelectedName: this.state.paddocks[i].name});
          this.setState({dinosaurs: this.state.paddocks[i].occupants});
        }
      }
    }
  }

  handleDinoSelected(e){
    if(e){
        this.setState({dinoSelected: e.target.value});
      }
  }

  handleSubmit(event) {
    event.preventDefault();

    this.props.handleDinosaurTransfer(this.state.dinoSelected, this.state.newPaddockSelected);
    this.setState({transferDetails: []});
  }

  render(){

    let dinos = this.state.dinosaurs;
    let paddocks = this.state.paddocks;
    let individualDinos = dinos.map((dinosaur) =>
                 <option key={dinosaur.id} value={dinosaur.id}>{dinosaur.name}</option>
             );
    let individualPaddocks = paddocks.map((paddock) =>
                  <option key={paddock.name} value={paddock.name}>{paddock.name}</option>
              );
    let individualNewPaddocks = paddocks.map((paddock) =>
                  <option key={paddock.name} value={paddock.name}>{paddock.name}</option>
              );
  return(
    <>
      <h4>Transfer Dino</h4>
      <p>Select Current Paddock</p>
      <select value={this.state.paddockSelectedName} onChange={this.handlePaddockSelected}>
        {individualPaddocks}
      </select>
      <p>Select Dinosaur By Name</p>
      <select value={this.state.dinoSelected} onChange={this.handleDinoSelected}>
         {individualDinos}
      </select>
      <p>Select New Paddock</p>
      <select value={this.state.newPaddockSelected} onChange={this.handleNewPaddockSelected}>
        {individualNewPaddocks}
      </select>
      <form>
        <input type="submit" value="Transfer Dinosaur" />
      </form>
    </>
  );
}
}

export default TransferDino;
