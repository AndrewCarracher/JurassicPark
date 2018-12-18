import React from 'react';

const RamgaeBoxStatus = (props) => {

  if(props.status === true){
      return (
            <p>Rampaging</p>
      );
    }
    else if (props.status === false) {
      return (
            <p>Not Rampaging</p>
      );
    }
    else {return null;}

}

export default RamgaeBoxStatus;
