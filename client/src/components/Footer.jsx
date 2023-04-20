import styled from "styled-components";
import BREAKPOINT from "../breakpoint.js";

const Container = styled.footer`
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  @media screen and (max-width: ${BREAKPOINT.tablet}) {
    flex-direction: column;
  }

  background-color: hsl(210, 8%, 15%);
  .logo {
    margin: 1rem;
    cursor: pointer;
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      margin-left: 2rem;
      margin-right: 2rem;
    }
    @media screen and (max-width: ${BREAKPOINT.mobile}px) {
      display: none;
    }
  }
`;

const Content = styled.div`
  margin: 2.5rem 0 2.5rem 0;
  @media screen and (max-width: ${BREAKPOINT.tablet}px) {
    margin: 1.5rem 0 1.5rem 0;
  }

  display: flex;
  flex-direction: ${(props) => props.direction || "column"};
  justify-content: ${(props) => props.justify || "flex-start"};

  .title {
    margin-bottom: 1.2rem;
    font-size: 0.75rem;
    font-weight: 700;
    color: hsl(210deg 8% 65%);
    cursor: pointer;
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      margin-left: 2rem;
      margin-right: 2rem;
    }
  }
  > ul {
    list-style: none;
    display: flex;
    flex-direction: ${(props) => props.direction || "column"};
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      margin-left: 2rem;
      flex-direction: row;
      flex-wrap: wrap;
    }
    > li {
      margin-bottom: 0.6rem;
      margin-right: 0.6rem;
      font-size: 0.65rem;
      font-weight: 600;
    }
    .list {
      margin: 0.5rem 0 0.5rem 0;
      text-decoration: none;
      color: hsl(210deg 8% 50%);
    }
  }
  .sns {
    margin: 0 0 12rem 0;
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      margin: 0;
    }
  }
  .copyright {
    font-size: 0.65rem;
    font-weight: 600;
    color: hsl(210deg 8% 50%);
    @media screen and (max-width: ${BREAKPOINT.tablet}) {
      margin-left: 2rem;
    }
  }
`;

const content = [
  {
    id: 1,
    title: "STACK OVERFLOW",
    list: [{ Questions: "/" }, { Help: "https://stackoverflow.com/help" }],
  },
  {
    id: 2,
    title: "PRODUCTS",
    list: [
      { Teams: "/" },
      { Advertising: "/" },
      { Collectives: "/" },
      { Talent: "/" },
    ],
  },
  {
    id: 3,
    title: "COMPANY",
    list: [
      { About: "/" },
      { Press: "/" },
      { "Work Here": "/" },
      { Legal: "/" },
      { "Privacy Policy": "/" },
      { "Terms of Service": "/" },
      { "Contact Us": "/" },
      { "Cookie Settings": "/" },
      { "Cookie Policy": "/" },
    ],
  },
  {
    id: 4,
    title: "STACK EXCHANGE NETWORK",
    list: [
      { Technology: "/" },
      { "Culture & recreation": "/" },
      { "Life & arts": "/" },
      { Science: "/" },
      { Professional: "/" },
      { Business: "/" },
      { "\u00A0": "" },
      { API: "/" },
      { Data: "/" },
    ],
  },
];

const snsList = [
  { Blog: "/" },
  { Facebook: "/" },
  { Twitter: "/" },
  { LinkdIn: "/" },
  { Instagram: "/" },
];

export const Footer = () => {
  return (
    <Container>
      <a className="logo" href="/" aria-label="Stack Overflow">
        <svg aria-hidden="true" width="32" height="37" viewBox="0 0 32 37">
          <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
          <path
            d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
            fill="#F48024"
          ></path>
        </svg>
      </a>

      {content.map(({ id, title, list }) => (
        <Content key={id}>
          <h5 className="title">{title}</h5>
          <ul>
            {list.map((list) => (
              <li key={Object.keys(list)[0]}>
                <a className="list" href={Object.values(list)[0]}>
                  {Object.keys(list)[0]}
                </a>
              </li>
            ))}
          </ul>
        </Content>
      ))}
      <Content justify={"space-between"}>
        <Content className="sns" direction={"row"}>
          <ul>
            {snsList.map((list) => (
              <li key={Object.keys(list)[0]}>
                <a className="list" href={Object.values(list)[0]}>
                  {Object.keys(list)[0]}
                </a>
              </li>
            ))}
          </ul>
        </Content>
        <div className="copyright">
          <p>Site design / logo © 2022 Stack Exchange Inc; </p>
          <p>user contributions licensed under CC BY-SA. </p>
          <p>rev 2022.12.21.43127</p>
        </div>
      </Content>
    </Container>
  );
};
