import React from 'react'

import { Button } from 'reactstrap';
import { Link } from "react-router-dom";
import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import 'react-pro-sidebar/dist/css/styles.css';


export default function SideBar() {
  return (
    <div>
     <ProSidebar>
  <Menu>
    <MenuItem>Dashboard</MenuItem>
    <MenuItem>Register Items</MenuItem>
    <SubMenu title="Manage Items">
      <MenuItem>Direct Booking </MenuItem>
      <MenuItem>Go For Auction </MenuItem>
    </SubMenu>
    <MenuItem>Check Auction Details</MenuItem>
    <MenuItem>Setting</MenuItem>
    
  </Menu>
</ProSidebar>;
    </div>
  )
}
