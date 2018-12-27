import React from 'react';

const PetList = (props) => {

  return (
    <>
    {props.list.occupants.map(occupant => (
      <div className ="list_item" key={occupant.id}>
          <p>Name: {occupant.name}</p>
          <p>Species: {occupant.type}</p>
          <p>Fed: {props.fed}</p>
      </div>
    ))}
    </>
  )
}



export default PetList;
