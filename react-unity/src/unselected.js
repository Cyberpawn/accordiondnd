import React from 'react';
import "./app.css";

class Unselected extends React.Component {
   render() {
      return (
         <div>
            <Header/>
         </div>
      );
   }
}
class Header extends React.Component {
   render() {
      return (
         <div className="header3">
            <h1 className="head1">Non-Active Endpoints</h1>
         </div>
      );
   }
}


export default Unselected;

