import React from 'react';
import "./app.css";

class Selected extends React.Component {
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
         <div className="header2">
            <h1 className="head1">Active Endpoints</h1>
         </div>
      );
   }
}


export default Selected;

