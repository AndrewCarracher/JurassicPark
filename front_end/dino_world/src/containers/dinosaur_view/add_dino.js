import React, { Component } from 'react';

class AddDino extends Component {
  constructor(props){
    super(props)
    this.state ={
      name: [],
      age: [],
      species: [],
      fed: [],
      eatsMeat: []
    }
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleAgeChange = this.handleAgeChange.bind(this);
    this.handleSpeciesChange = this.handleSpeciesChange.bind(this);
    this.handleFedChange = this.handleFedChange.bind(this);
    this.handleEatsMeatChange = this.handleEatsMeatChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleNameChange(event) {
    const name = event.target.value;
    this.setState({name: name});
  }
  handleAgeChange(event) {
    const age = event.target.value;
    this.setState({age: age});
  }
  handleSpeciesChange(event) {
    const species = event.target.value;
    this.setState({species: species});
  }
  handleFedChange(event) {
    const fed = event.target.value;
    console.log(event.target.value);
    this.setState({fed: fed});
  }
  handleEatsMeatChange(event) {
    const eatsMeat = event.target.value;
    console.log(event.target.value);
    this.setState({eatsMeat: eatsMeat});
  }

  handleSubmit(event) {
    event.preventDefault();
    const {name, age, species, fed, eatsMeat} = this.state;

    if (!name || !age || !species || !fed || !eatsMeat) {
      return;
    }

    const comment = {name: name, age: age, species: species, fed: fed, eatsMeat: eatsMeat};
    this.props.handleDinosaurSubmit(comment);
    this.setState({name: '', age: '', species: '', fed: '', eatsMeat: ''});
  }

render(){
  return(
    <>
      <h4>Add Dino</h4>
      <form onSubmit={this.handleSubmit}>
        <input type="text" placeholder="name" value={this.state.name} onChange={this.handleNameChange}/><br/>
        <input type="text" placeholder="age" value={this.state.age} onChange={this.handleAgeChange}/><br/>
        <input type="text" placeholder="species" value={this.state.species} onChange={this.handleSpeciesChange}/><br/>
        <input type="radio" name="fed" value="true" onChange= {(e) => this.handleFedChange(e)}/>fed
        <input type="radio" name="fed" value="false" onChange= {(e) => this.handleFedChange(e)} />not fed<br/>
        <input type="radio" name="eatsMeat" value="true" onChange= {(e) => this.handleEatsMeatChange(e)}  />Carnivore
        <input type="radio" name="eatsMeat" value="false" onChange= {(e) =>this.handleEatsMeatChange(e)} />Herbivore<br/>
        <input type="submit" value="Add Dinosaur"/>
      </form>
    </>
  );
}
}

export default AddDino;
