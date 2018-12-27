import React, { Component } from 'react';
import Request from '../../helpers/request';

class RemoveDino extends Component {
  constructor(props){
    super(props)
    this.state = {
      dinosaurs: [],
      paddocks: [],
      paddockSelected: [],
      dinoSelected: [],
      id: []
    }
    this.handleDinoSelected = this.handleDinoSelected.bind(this);
    this.handlePaddockSelected = this.handlePaddockSelected.bind(this);
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

handlePaddockSelected(e){
  if(e){
    for(let i = 0; i< this.state.paddocks.length;  i++){
      if (this.state.paddocks[i].name === e.target.value){
        this.setState({paddockSelected: this.state.paddocks[i]});
        this.setState({dinosaurs: this.state.paddocks[i].occupants})
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

  this.props.handleDinosaurRemove(this.state.dinoSelected);
  this.setState({dinoSelected: []});
}

render(){

  console.log(this.state.paddockSelected);

  let dinos = this.state.dinosaurs;
  let paddocks = this.state.paddocks;
  let individualDinos = dinos.map((dinosaur) =>
               <option key={dinosaur.id} value={dinosaur.id}>{dinosaur.name}</option>
           );
  let individualPaddocks = paddocks.map((paddock) =>
                <option key={paddock.name} value={paddock.name}>{paddock.name}</option>
            );

       return (
        <div>
            <>
            <h4>Kill Dino</h4>
            <p>Select Paddock</p>
            <select value={this.state.paddockSelected} onChange={this.handlePaddockSelected}>
              {individualPaddocks}
            </select>
            <p>Select Dinosaur By Name</p>
            <select value={this.state.dinoSelected} onChange={this.handleDinoSelected}>
               {individualDinos}
            </select>
            <form onSubmit={this.handleSubmit}>
              <input type="submit" value="Kill Dinosaur" />
            </form>
            </>
        </div>
       )
}
}

export default RemoveDino;
