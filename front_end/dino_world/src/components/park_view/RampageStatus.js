import React from 'react';

const RampageStatus = (props) => {
  if(props.rampaging === true){
    return (
      <>
        <h3>Rampage Status</h3>
        <p>Rampaging</p>
        <button onClick={props.onClick}>Change</button>
      </>
    )
  }
  return (
    <>
      <h3>Rampage Status</h3>
      <p>Not Rampaging</p>
      <button onClick={props.onClick}>Change</button>
    </>
  )
}

export default RampageStatus;
