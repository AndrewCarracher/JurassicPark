import React, { Component } from 'react';
import CurrentVisitorCount from '../../components/CurrentVisitorCount';
import AddVisitor from '../../components/AddVisitor';
import Request from '../../helpers/request'

class VisitorCount extends Component {
  constructor(props){
    super(props);
    this.state = {visitor_count: [], capacity: []}
    this.handleAddVisitor = this.handleAddVisitor.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/park").then((data) => {
      this.setState({capacity: data[0].capacity});
      this.setState({visitor_count: data[0].visitorCount});
    })
  }

  handleAddVisitor(){
    console.log(this.props);
    let count = this.state.visitor_count;
    count += 1;
    this.setState({visitor_count: count});
  }

  render() {
    return (
        <>
          <div id = "visitor_count">
            <p>VisitorCount</p>
            <CurrentVisitorCount count = {this.state.visitor_count} capacity = {this.state.capacity}/>
            <AddVisitor handleAddVisitor = {this.handleAddVisitor}/>
          </div>
        </>
    );
  }
}

export default VisitorCount;
