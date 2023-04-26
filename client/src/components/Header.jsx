import styled from "styled-components";
import { BtnBlueFill, BtnBlueLine, LinkBlue } from "../styles/common";
import sprites from "../assets/sprites.svg";
import userImg from "../assets/user.png";
import { useState, useEffect } from "react";
import axios from "axios";

const StyledHeader = styled.header`
  width: 100%;
  min-width: auto;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 2px 0px,
    rgba(0, 0, 0, 0.05) 0px 1px 4px 0px, rgba(0, 0, 0, 0.05) 0px 2px 8px 0px;
  z-index: 5050;
  background-color: var(--bg-gray);
  height: 50px;
  display: flex;
  align-items: center;
  border-top: 3px solid var(--orange);
  position: relative;
  color: var(--gray);

  .container {
    width: 1264px;
    max-width: 100%;
    margin: 0 auto;
    height: 100%;
    display: flex;
    align-items: center;
  }

  .logo {
    padding: 0 0.8rem;
    height: 100%;
    display: flex;
    align-items: center;
    background-color: transparent;

    &:hover {
      background-color: var(--hover-gray);
    }

    h1 {
      display: inline-block;
      text-indent: -9999em;
      margin-left: 0;
      width: 150px;
      height: 30px;
      margin-top: -4px;
      background: url(${sprites}) no-repeat 0 -500px;
    }
  }

  .products {
    padding: 0.6rem 1.2rem;
    border-radius: 2rem;
    line-height: 1.5em;

    &:hover {
      background: var(--hover-gray);
    }
  }

  #search {
    position: relative;
    flex-grow: 1;
    margin: 0 1em;

    input[type="text"] {
      display: block;
      width: 100%;
      padding: 0.8rem 0.9rem 0.8rem 3.2rem;
      border-radius: 3px;
      border: 1px solid var(--input-border);
      outline: none;

      &:focus {
        border-color: var(--light-blue);
        box-shadow: 0 0 0 0.4rem #0074cc26;
      }

      &:focus ~ .search-popover {
        display: block;
      }
    }

    .svg-icon {
      fill: var(--header-gray);
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      left: 0.7em;
    }

    .search-popover {
      display: none;
      position: absolute;
      top: calc(100% + 1.2rem);
      left: 0;
      right: 0;
      background: var(--white);
      border: 1px solid var(--box-border);
      border-radius: 0.5rem;
      box-shadow: 0 0.1rem 0.3rem hsla(0, 0%, 0%, 0.06),
        0 0.2rem 0.6rem hsla(0, 0%, 0%, 0.06),
        0 0.3rem 0.8rem hsla(0, 0%, 0%, 0.09);

      &:after {
        content: "";
        display: block;
        border: 1px solid var(--box-border);
        border-right-color: transparent;
        border-bottom-color: transparent;
        background-color: var(--white);
        width: 1.2rem;
        height: 1.2rem;
        position: absolute;
        top: -0.7rem;
        left: 50%;
        transform: translateX(-50%) rotate(45deg);
      }

      & > div {
        padding: 1.2rem;
      }

      .search-tips {
        border-bottom: 1px solid var(--box-border);
        ul {
          display: flex;
          justify-content: space-between;
          align-items: center;
          flex-wrap: wrap;
        }
        li {
          width: 50%;
          padding: 0.5em;
          color: var(--black);
          span {
            color: var(--gray);
          }
        }
      }

      .search-btns {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }
    }
  }

  .header-menu {
    display: flex;
    height: 100%;

    .svg-icon {
      fill: var(--gray);
    }

    a {
      padding: 0 1rem;
      display: flex;
      align-items: center;

      &:hover {
        background: var(--hover-gray);
      }
    }
    .profile img {
      display: block;
      width: 2.4rem;
      height: 2.4rem;
      border-radius: 0.3rem;
    }

    button {
      align-self: center;
    }
  }
`;

const Header = () => {
  // 임시 state
  const [isLogin, setIsLogin] = useState(false);

  // login state 변경
  useEffect(() => {
    if (localStorage.accessToken !== undefined) {
      setIsLogin(true);
    }
  }, []);

  // logout event
  const logoutHandler = () => {
    return axios
      .patch("/users/logout")
      .then((res) => {
        localStorage.removeItem("userInfo");
        setIsLogin(false);
      })
      .catch((err) => {
        alert(err);
      });
  };

  return (
    <StyledHeader>
      <div className="container">
        <a href="/" className="logo">
          <h1>Stack Overflow</h1>
        </a>
        <a href="/" className="products">
          Products
        </a>
        <form id="search">
          <div>
            <input type="text" placeholder="Search..." />
            <svg
              aria-hidden="true"
              className="svg-icon"
              width="18"
              height="18"
              viewBox="0 0 18 18"
            >
              <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
            </svg>
            <div className="search-popover">
              <div className="search-tips">
                <ul>
                  <li>
                    [tag] <span>search within a tag</span>
                  </li>
                  <li>
                    [answers:0] <span>unanswered questions</span>
                  </li>
                  <li>
                    [user:1234] <span>search by author</span>
                  </li>
                  <li>
                    [score:3] <span>posts with a 3+ score</span>
                  </li>
                  <li>
                    [&quot;words here&quot;] <span>exact phrase</span>
                  </li>
                  <li>
                    [is:question] <span>type of post</span>
                  </li>
                  <li>
                    [collective:&quot;Name&quot;]{" "}
                    <span>collective content</span>
                  </li>
                  <li>
                    [isaccepted:yes] <span>search within status</span>
                  </li>
                </ul>
              </div>
              <div className="search-btns">
                <BtnBlueLine>Ask a question</BtnBlueLine>
                <LinkBlue href="/">Search help</LinkBlue>
              </div>
            </div>
          </div>
        </form>
        <nav className="header-menu">
          {isLogin ? (
            <>
              <a href="/" className="profile">
                <img src={userImg} alt="user profile img" />
              </a>
              <a href="/" className="inbox">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconInbox"
                  width="20"
                  height="18"
                  viewBox="0 0 20 18"
                >
                  <path d="M4.63 1h10.56a2 2 0 0 1 1.94 1.35L20 10.79V15a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-4.21l2.78-8.44c.25-.8 1-1.36 1.85-1.35Zm8.28 12 2-2h2.95l-2.44-7.32a1 1 0 0 0-.95-.68H5.35a1 1 0 0 0-.95.68L1.96 11h2.95l2 2h6Z"></path>
                </svg>
              </a>
              <a href="/" className="achievments">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconAchievements"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M15 2V1H3v1H0v4c0 1.6 1.4 3 3 3v1c.4 1.5 3 2.6 5 3v2H5s-1 1.5-1 2h10c0-.4-1-2-1-2h-3v-2c2-.4 4.6-1.5 5-3V9c1.6-.2 3-1.4 3-3V2h-3ZM3 7c-.5 0-1-.5-1-1V4h1v3Zm8.4 2.5L9 8 6.6 9.4l1-2.7L5 5h3l1-2.7L10 5h2.8l-2.3 1.8 1 2.7h-.1ZM16 6c0 .5-.5 1-1 1V4h1v2Z"></path>
                </svg>
              </a>
              <a href="/" className="help">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconHelp"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8Zm.81 12.13c-.02.71-.55 1.15-1.24 1.13-.66-.02-1.17-.49-1.15-1.2.02-.72.56-1.18 1.22-1.16.7.03 1.2.51 1.17 1.23ZM11.77 8c-.59.66-1.78 1.09-2.05 1.97a4 4 0 0 0-.09.75c0 .05-.03.16-.18.16H7.88c-.16 0-.18-.1-.18-.15.06-1.35.66-2.2 1.83-2.88.39-.29.7-.75.7-1.24.01-1.24-1.64-1.82-2.35-.72-.21.33-.18.73-.18 1.1H5.75c0-1.97 1.03-3.26 3.03-3.26 1.75 0 3.47.87 3.47 2.83 0 .57-.2 1.05-.48 1.44Z"></path>
                </svg>
              </a>
              <a href="/" className="stack-exchange">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconStackExchange"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M15 1H3a2 2 0 0 0-2 2v2h16V3a2 2 0 0 0-2-2ZM1 13c0 1.1.9 2 2 2h8v3l3-3h1a2 2 0 0 0 2-2v-2H1v2Zm16-7H1v4h16V6Z"></path>
                </svg>
              </a>
              <BtnBlueLine
                className="btn-logout"
                onClick={() => {
                  logoutHandler();
                }}
              >
                Log out
              </BtnBlueLine>
            </>
          ) : (
            <>
              <BtnBlueLine
                className="btn-login"
                onClick={() => setIsLogin(true)}
              >
                Log in
              </BtnBlueLine>
              <BtnBlueFill className="btn-signup">Sign up</BtnBlueFill>
            </>
          )}
        </nav>
      </div>
    </StyledHeader>
  );
};

export default Header;
