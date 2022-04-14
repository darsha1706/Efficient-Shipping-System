import React from "react";
import { Link } from "react-router-dom";
import { Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle, Col, Row } from "reactstrap";
import transLogin1 from "../assets/transLogin1.png";
import custLogin1 from "../assets/custLogin1.jpg";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
// import "../styles/Contact.css";

function Register() {
  return (
    <div>
<Navbar/>

<Row>
  <Col sm="6">
    <Card body>
      <CardTitle tag="h1">
        Customer Register
      </CardTitle>
     
      <Button href="custRegister" type="submit">
       Register
      </Button>
    </Card>
  </Col>

  <Col sm="6">
    <Card body>
      <CardTitle tag="h1">
       Transporter Register
      </CardTitle>
      
      <Button href="transRegister" type="submit">
        Register
      </Button>
    </Card>
  </Col>
</Row>
<Footer/>
</div>
  );
}

export default Register;
