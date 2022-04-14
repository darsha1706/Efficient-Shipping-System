import React from "react";
import { Link } from "react-router-dom";
import { Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle, Col, Row } from "reactstrap";
// import AdminPanelSettingsOutlinedIcon from '@mui/icons-material/AdminPanelSettingsOutlined';
import transLogin1 from "../assets/transLogin1.png";
import custLogin1 from "../assets/custLogin1.jpg";
// import "../styles/Contact.css";
import green from "@material-ui/core/colors/green";
import AdminIcon from "@material-ui/icons/AccountCircleRounded";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

  
function Contact() {

  return (
    <div>
<Navbar/>

<Row>
<Col sm="4">
    <Card body>
   
      <CardTitle tag="h1">
       <center>Admin Login</center>
      </CardTitle>
    
    
      <Button href="adminLogin" type="submit">
        Login
      </Button>
    </Card>
    </Col>
  <Col sm="4">
    <Card body>
      <CardTitle tag="h1">
       <center> Customer Login</center>
      </CardTitle>
     
      <Button href="custLogin" type="submit">
       Login
      </Button>
    </Card>
  </Col>

  <Col sm="4">
    <Card body>
      <CardTitle tag="h1">
       <center>Transporter Login</center>
      </CardTitle>
      
      <Button href="transLogin" type="submit">
        Login
      </Button>
    </Card>
  </Col>
</Row>
<Footer/>
</div>
  );
}

export default Contact;
