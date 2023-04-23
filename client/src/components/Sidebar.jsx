import styled from "styled-components";
import favicons from "../assets/favicons-sprite32.png";
import BREAKPOINT from "../breakpoint.js";

const StyledSidebar = styled.aside`
  width: 30rem;
  margin-bottom: 2.4rem;

  @media screen and (max-width: ${BREAKPOINT.tablet}) {
    display: none;
  }

  & > div {
    border: 1px solid var(--side-border);
    border-radius: 3px;
    box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
      0 2px 8px hsla(0, 0%, 0%, 0.05);
    background-color: var(--side-bg);
  }

  ul {
    li {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      line-height: 1.3em;
      padding: 0 1.5rem;
      margin: 1rem 0;

      &:first-of-type {
        margin: 0;
        padding: 1rem 1.5rem;
        background-color: var(--side-title);
        border-top: 1px solid var(--side-border);
        border-bottom: 1px solid var(--side-border);
        font-weight: 700;
      }

      a {
        flex-basis: calc(100% - 2.5rem);
      }
    }

    &:first-of-type li:first-of-type {
      border-top: 0;
    }
  }

  .icon {
    display: block;
    width: 1.6rem;
    height: 1.6rem;
    background: url(${favicons}) no-repeat;
    background-size: 1.6rem;

    &.bubble {
      background-position: 0 -612rem;
    }

    &.stack {
      background-position: 0 -615.6rem;
    }
  }
`;

const Sidebar = () => {
  return (
    <StyledSidebar>
      <div>
        <ul>
          <li>The Overflow Blog</li>
          <li>
            <svg
              aria-hidden="true"
              className="svg-icon iconPencilSm"
              width="14"
              height="14"
              viewBox="0 0 14 14"
            >
              <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
            </svg>
            <a href="/">The philosopher who believes in Web Assembly</a>
          </li>
          <li>
            <svg
              aria-hidden="true"
              className="svg-icon iconPencilSm"
              width="14"
              height="14"
              viewBox="0 0 14 14"
            >
              <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
            </svg>
            <a href="/">Community is the future of AI</a>
          </li>
        </ul>
        <ul>
          <li>Featured on Meta</li>
          <li>
            <span className="icon bubble"></span>
            <a href="/">
              Improving the copy in the close modal and post notices - 2023
              edition
            </a>
          </li>
          <li>
            <span className="icon bubble"></span>
            <a href="/">
              New blog post from our CEO Prashanth: Community is the future of
              AI
            </a>
          </li>
          <li>
            <span className="icon stack"></span>
            <a href="/">Temporary policy: ChatGPT is banned</a>
          </li>
          <li>
            <span className="icon stack"></span>
            <a href="/">The [protection] tag is being burninated</a>
          </li>
          <li>
            <span className="icon stack"></span>
            <a href="/">
              Content Discovery initiative 4/13 update: Related questions using
              a Machine...
            </a>
          </li>
        </ul>
        <ul>
          <li>Hot Meta Posts</li>
          <li>
            <span>13</span>
            <a href="/">We need a better [word] for this tag</a>
          </li>
        </ul>
      </div>
    </StyledSidebar>
  );
};

export default Sidebar;
