import React, {Component} from 'react';

class Navbar extends Component {

  render(){
    return(
      <>
        <ul id = "navbar">
          <li className = "navitem">Park</li>
          <li className = "navitem">Paddocks</li>
          <li className = "navitem">Dinosaurs</li>
        </ul>
      </>
    );
  }
}

export default Navbar;
