import React from 'react';
import "./app.css";

class Details extends React.Component {
   render() {
      return (
         <div>
            <Header/>
            <Content/>
         </div>
      );
   }
}
class Header extends React.Component {
   render() {
      return (
         <div className="header1">
            <h1 className="head2">AC</h1>
         </div>
      );
   }
}

class Content extends React.Component {
    render() {
       return (
          <div>
         <span className="spancss">Manage your account</span>
        <div className="formbox">
        <form action="/action_page.php">
          {/* <label htmlFor="fname">Name</label> */}
          <input  class="mainLoginInput" type="text" id="fname" name="Name" placeholder="Name" />
          {/* <label htmlFor="lname">URL</label> */}
          <input  class="mainLoginInput" type="text" id="lname" name="URL" placeholder="URL" />
          {/* <label htmlFor="country">Description</label> */}
          <input   class="mainLoginInput" type="text" id="fname" name="Name" placeholder="Description" />
          {/* <button className="button" id="save">Save Changes</button> */}
        </form>
      </div>
      </div>
             );
    }
 }

export default Details;

