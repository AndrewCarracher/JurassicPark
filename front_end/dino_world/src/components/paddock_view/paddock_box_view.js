import React from 'react';

const PaddockBoxView = (props) => {

if(props.paddock.occupants){
  if(props.paddock.containsCarnivores){
    return(
        <>
          <div className="paddock_name">{props.paddock.name}</div>
          <div className="paddock_capacity">{props.paddock.occupants.length} / {props.paddock.capacity}</div>
          <div className="paddock_eats_meat">Contains Carnivores</div>
        </>
    );
  }
  else{
    return(
        <>
          <div className="paddock_name">{props.paddock.name}</div>
          <div className="paddock_capacity">{props.paddock.occupants.length} / {props.paddock.capacity}</div>
          <div className="paddock_eats_meat">Does Not Contain Carnivores</div>
        </>
    );
  }
}

return null;
}

export default PaddockBoxView;
