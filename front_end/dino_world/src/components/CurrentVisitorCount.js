import React, { Component } from 'react';


class CurrentVisitorCount extends Component {

  render(){
    let count = this.props.count;
    let capacity = this.props.capacity;
    return (
        <>
          <p>{count} / {capacity}</p>
        </>
    );
  }

}

export default CurrentVisitorCount;
