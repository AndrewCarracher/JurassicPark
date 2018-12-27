import React from 'react';

const ParkStatus = (props) => {
  if(props.parkOpen === true){
    return (
      <>
        <h3>Park Status</h3>
        <p>Open</p>
        <button onClick={props.onClick}>Change</button>
      </>
    )
  }
  return (
    <>
      <h3>Park Status</h3>
      <p>Closed</p>
      <button onClick={props.onClick}>Change</button>
    </>
  )
}

export default ParkStatus;
