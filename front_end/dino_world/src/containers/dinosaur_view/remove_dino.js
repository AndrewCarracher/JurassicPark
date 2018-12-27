import React, { Component } from 'react';
import Request from '../../helpers/request';

class RemoveDino extends Component {
  constructor(props){
    super(props)
    this.state = {
      dinosaurs: [],
      dinoSelected: [],
      id: []
    }
    this.handleDinoSelected = this.handleDinoSelected.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

componentDidMount(){
  const request = new Request();
  request.get("/dinosaurs/").then((data) => {
    this.setState({dinosaurs: data});
    })
}

handleDinoSelected(e){
  if(e){
      this.setState({dinoSelected: e.target.value});
    }
}

handleSubmit(event) {
  event.preventDefault();

  this.props.handleDinosaurRemove(this.state.dinoSelected);
  // this.setState({dinoSelected: []});
}

render(){

  let dinos = this.state.dinosaurs;
  let optionItems = dinos.map((dinosaur) =>
               <option key={dinosaur.id} value={dinosaur.id}>{dinosaur.name}</option>
           );

console.log(this.state.dinoSelected);
       return (
        <div>
            <>
            <p>Select Dinosaur By Name</p>
            <select value={this.state.dinoSelected} onChange={this.handleDinoSelected}>
               {optionItems}
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
