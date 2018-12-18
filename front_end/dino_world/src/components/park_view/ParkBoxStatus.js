import React from 'react';

const ParkBoxStatus = (props) => {

if(props.status === true){
    return (
          <p>Park Open</p>
    );
  }
  else if (props.status === false) {
    return (
          <p>Park Closed</p>
    );
  }
  else {return null;}
}

export default ParkBoxStatus;
