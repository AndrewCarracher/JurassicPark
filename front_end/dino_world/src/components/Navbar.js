import React from 'react';
import { Link } from "react-router-dom";

const Navbar = () => {

    return(
        <ul id = "navbar">
          <li className = "navitem">
            <Link to ="/park_overview">Park</Link>
          </li>
          <li className = "navitem">
            <Link to ="/paddocks_overview">Paddocks</Link>
          </li>
          <li className = "navitem">
            <Link to ="/dinosaurs_overview">Dinosaurs</Link>
          </li>
        </ul>
    );

}

export default Navbar;
