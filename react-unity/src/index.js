import React from 'react';
import ReactDOM from 'react-dom';
import Accordion from './app';
import Details from './details';
import Selected from './select';
import Unselected from './unselected';




ReactDOM.render(
<div className={ 'main-container' }>
  {/* <div className={ 'main-content-container' }>    */}
  {/* <div class="sc-ESoVU fAdtDU" height="192" style="outline: 1px dotted red ! important;cursor: crosshair !important;; outline: 1px dotted red ! important;cursor: crosshair !important;" cz-backup-style="outline: 1px dotted red ! important;cursor: crosshair !important;"><div><div class="Droplist-sc-1z05y4v-0 cLrmQm"><div><div><div class="Droplist__Trigger-sc-1z05y4v-3 eteVrT"><div><div class="sc-jKmXuR cfYJDu" tabindex="0"><span class="Icon__IconWrapper-dyhwwi-0 ieACwX" aria-label=""><svg width="24" height="24" viewBox="0 0 24 24" focusable="false" role="presentation"><path d="M3 4.995C3 3.893 3.893 3 4.995 3h14.01C20.107 3 21 3.893 21 4.995v14.01A1.995 1.995 0 0 1 19.005 21H4.995A1.995 1.995 0 0 1 3 19.005V4.995zM10.5 16.5L9 15l-3 3h12v-2.7L15 12l-4.5 4.5zM8 10a2 2 0 1 0 0-4 2 2 0 0 0 0 4z" fill="currentColor" fill-rule="evenodd"></path></svg></span></div></div></div></div><div class="Layer__FixedTarget-qunuuz-0 cXwmnx"><div style="height: 100%; width: 100%;"></div></div><div class="styledContentContainer-p0j3f7-0 caSnlw"><div style="top: 0px; left: 0px; position: absolute; z-index: 400; opacity: 0;"></div></div></div></div></div><p class="">Update your header image</p></div>{

  } */}
    {/* <div className="navbar">
        Manage Connections
    </div> */}
    <div className="formdetails">
        <Details/>
    </div>
    <div className={'accordion-container'}>
      
      
        {/* <Selected/> */}
        <Accordion/>
        
         
        {/* <Accordion/>  */}
      
      <br></br>
      <br></br>
      <br></br>
      <br></br>
        {/* <Unselected/>
        <Accordion/> */}
        {/* <Accordion/>
        <Accordion/> */}
      
        
    </div>

    
  {/* </div> */}
</div>,document.getElementById('root'))
