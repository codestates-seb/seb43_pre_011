import styled from "styled-components";
import Sidebar from "../components/Sidebar.jsx";
import TagInput from "../components/taginput.jsx";
import { BtnBlueFill, LinkBlue } from "../styles/common";
import BREAKPOINT from "../breakpoint";
import { useLocation, useNavigate } from "react-router-dom";
import Editor from "../components/editor.jsx";

const StyledUpdateQuestion = styled.div`
  width: calc(100% - 32.4rem);
  padding-left: 2.4rem;

  @media screen and (max-width: ${BREAKPOINT.tablet}) {
    width: 100%;
  }

  .yellow {
    background-color: var(--side-bg);
    border: 1px solid var(--side-border);
    border-radius: 3px;
    padding: 1rem 1.5rem;
    line-height: 1.3em;
    margin-bottom: 2rem;
  }

  label,
  & > p {
    font-weight: 700;
    font-size: 1.6rem;
    display: block;
    margin-bottom: 0.5rem;
  }

  & > input[type="text"] {
    display: block;
    width: 100%;
    padding: 0.8rem 0.9rem;
    border-radius: 3px;
    border: 1px solid var(--input-border);
    outline: none;
    margin-bottom: 2rem;

    &:focus {
      border-color: var(--light-blue);
      box-shadow: 0 0 0 0.4rem #0074cc26;
    }
  }

  > div {
    margin-bottom: 2rem;
  }

  .btns {
    display: flex;
    align-items: center;
    gap: 1em;
  }
`;

const UpdateQuestion = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const question = location.state;

  return (
    <div className="container">
      <StyledUpdateQuestion>
        <div className="yellow">
          Your edit will be placed in a queue until it is peer reviewed.
          <br />
          <br />
          We welcome edits that make the post easier to understand and more
          valuable for readers. Because community members review edits, please
          try to make the post substantially better than how you found it, for
          example, by fixing grammar or adding additional resources and
          hyperlinks.
        </div>
        <label htmlFor="title">Title</label>
        <input type="text" id="title" value={question.title} />
        <label htmlFor="body">Body</label>
        <Editor />
        <p>Tag</p>
        <TagInput tags={["javascript"]} />
        <label htmlFor="summary">Edit Summary</label>
        <input
          type="text"
          id="summary"
          placeholder="briefly explain your changes (corrected spelling, fixed grammar, improved formatting)"
        />
        <div className="btns">
          <BtnBlueFill>Save edits</BtnBlueFill>
          <LinkBlue onClick={() => navigate(-1)}>Cancel</LinkBlue>
        </div>
      </StyledUpdateQuestion>
      <Sidebar mode="update" />
    </div>
  );
};

export default UpdateQuestion;
