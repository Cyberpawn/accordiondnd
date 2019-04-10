import React from "react";
import "./app.css";
import { DragDropContext } from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';


class Accordion extends React.Component {
   constructor(props){
    super(props);
    this.state = {
      items: [
        {name:"Students",status:"active"},
        {name:"Teachers",status:"active"},
        {name:"Courses",status:"active"},
        {name:"Categories",status:"active"},
        {name:"Classes",status:"inactive"},
        {name:"Enrollments",status:"inactive"}
      ],
      open:{ open: false, class: "accordion"},
    };
  
    this.handleClick = this.handleClick.bind(this);
  }
  
 
  
  onDragStart = (ev,id) => {
    // console.log('dragstart:',id);
    ev.dataTransfer.setData("id",id);
  }

  onDragOver = (ev) => {
    
    ev.preventDefault();
  }
  

  onDrop = (ev, cat) => {  
    
    let id = ev.dataTransfer.getData("id");
    
    
    let items = this.state.items.filter((item) => {
    
        if (item.name === id) {
                 item.status = cat;           
        }              
         return item;       
     });        
     this.setState({           
        ...this.state,           
        items
     });    
  }

  handleClick() {
        
      this.setState({ open: !this.state.open })  

  }

   render () {
     const { open } = this.state;
      const classlist = open ? 'iconrotate' :''
      var items = {
         active:[],
         inactive:[]
      }

      this.state.items.forEach((t) => {
        items[t.status].push(
          <ul className="list">
            <li  key={t.name} className="list-item"  onDragStart={(e)=>this.onDragStart(e, t.name)}    draggable     >
              <div className="data" ><button className="but">GET</button><strong>{t.name}</strong></div>
            </li>
         </ul>

      );
      });


    return(

      <div className={open ? 'accordion-open'   : 'accordion'}>

          <div className="header2">
            <h1 className="head1">Active Endpoints</h1>
         </div>
          <h1 className="accordion-heading">
            <a onClick={this.handleClick} href="#">Canvas<i  style={{marginLeft:"auto"}} className={`material-icons icontrans ${classlist}`}>expand_less</i></a>
           </h1>

        <div className="accordion-content">
          <div onDragOver={(e)=>this.onDragOver(e)} onDrop={(e)=>this.onDrop(e, "active")}>
                {items.active}

          </div>     
         </div>
          <br></br>
          <br></br>
          <br></br>
          <br></br>
          <div className="header3">
            <h1 className="head3">Non-Active Endpoints</h1>
         </div>
          <h1 className="accordion-heading">
            <a onClick={this.handleClick} href="#">Canvas<i  style={{marginLeft:"auto"}} className={`material-icons icontrans ${classlist}`}>expand_less</i></a>
           </h1>
         <div className="accordion-content">
            <div  onDrop={(e)=>this.onDrop(e, "inactive")} onDragOver={(e)=>this.onDragOver(e)} >
                 
                {items.inactive}
            </div>
         </div>
      </div>
    );
  }
}

export default Accordion;


