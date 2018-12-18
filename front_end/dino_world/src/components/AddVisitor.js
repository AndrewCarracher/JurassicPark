import React from 'react';

const AddVisitor = (props) => {

    const onHandleAddVisitor = () => {
      props.handleAddVisitor();
    }

    return (
        <>
          <button onClick={onHandleAddVisitor}>Add Visitor</button>
        </>
    );

}

export default AddVisitor;
