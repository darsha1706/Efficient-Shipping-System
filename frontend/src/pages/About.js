import React from "react";
import { Col, Container, Row } from "reactstrap";
import About1 from "../assets/about.png";
import About2 from "../assets/about1.png"
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import "../styles/About.css";
function About() {
  return (
    <div>
      <Navbar/>
    <div className="about">
     
      <div
        className="aboutTop"
        style={{ backgroundImage: `url(${About1})` }}
      ></div>
      <div>
      
      </div>

        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime
          mollitia, molestiae quas vel sint commodi repudiandae consequuntur
          voluptatum laborum numquam blanditiis harum quisquam eius sed odit
          fugiat iusto fuga praesentium optio, eaque rerum! Provident similique
          accusantium nemo autem. Veritatis obcaecati tenetur iure eius earum ut
          molestias architecto voluptate aliquam nihil, eveniet aliquid culpa
          officia aut! Impedit sit sunt quaerat, odit, tenetur error, harum
          nesciunt ipsum debitis quas aliquid. Reprehenderit, quia. Quo neque
          error repudiandae fuga? Ipsa laudantium molestias eos sapiente
          officiis modi at sunt excepturi expedita sint? Sed quibusdam
          recusandae alias error harum maxime adipisci amet laborum.
          Perspiciatis minima nesciunt dolorem! Officiis iure rerum voluptates a
          cumque velit
        </p>
      </div>
      <Footer/>
      </div>
  );
}

export default About;
