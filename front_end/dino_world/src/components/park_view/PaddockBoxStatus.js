import React from 'react';

const PaddockBoxStatus = (props) => {

console.log(props);

if(props.paddocks.occupants){
  if(props.paddocks.containsCarnivores){
    return(
      <>
        <div className="paddock_name">{props.paddocks.name}</div>
        <div className="paddock_capacity">{props.paddocks.occupants.length} / {props.paddocks.capacity}</div>
        <div className="paddock_eats_meat">Contains Carnivores</div>
      </>
    );
  }
  else{
    return(
      <>
        <div className="paddock_name">{props.paddocks.name}</div>
        <div className="paddock_capacity">{props.paddocks.occupants.length} / {props.paddocks.capacity}</div>
        <div className="paddock_eats_meat">Does Not Contain Carnivores</div>
      </>
    );
  }
}

return null;
}

export default PaddockBoxStatus;
