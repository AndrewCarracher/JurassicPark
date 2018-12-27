import React from 'react';

const VisitorCount = (props) => {
  return (
    <>
      <h3>Visitor Count</h3>
      <p>{props.visitorCount} / 15000</p>
      <button onClick={props.onClick}>Change</button>
    </>
  )
}

export default VisitorCount;
