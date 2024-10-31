import React from "react";
import { styled } from "styled-components";

const bear =
  "https://w7.pngwing.com/pngs/0/787/png-transparent-cool-bear-bear-in-hoodie-with-eyeglasses-thumbnail.png";
const styles = { width: "150px", height: "150px" };
const stylyedFooter = styled.div``;

const Footer = () => {
  return (
    <div>
      <stylyedFooter>
        <img src={bear} style={styles} />
      </stylyedFooter>
    </div>
  );
};

export default Footer;
