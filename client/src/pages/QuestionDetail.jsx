import styled from "styled-components";
import Sidebar from "../components/Sidebar.jsx";
import { BtnBlueFill } from "../styles/common.js";
import BREAKPOINT from "../breakpoint.js";
import DetailBody from "../components/DetailBody.jsx";
import Editor from "../components/editor.jsx";
import { useLocation, useNavigate } from "react-router-dom";

const StyledQuestion = styled.div`
  width: 100%;
  padding: 0 0 2.4rem 2.4rem;

  .title {
    border-bottom: 1px solid var(--hover-gray);
    margin-bottom: 1.6rem;

    & > div {
      display: flex;
      justify-content: space-between;
      align-items: flex-start;
      margin-bottom: 1rem;
    }

    h2 {
      font-size: 2.7rem;
      line-height: 1.3em;
      flex: 0 1 auto;

      & + button {
        flex: 0 0 auto;
      }
    }

    .info {
      justify-content: flex-start;
      color: var(--gray);
      gap: 1rem;
      margin-bottom: 2.5rem;
      span {
        color: var(--black);
      }
    }
  }

  .content-wrap {
    display: flex;
    justify-content: space-between;

    .mainbar {
      width: calc(100% - 32.4rem);

      @media screen and (max-width: ${BREAKPOINT.tablet}) {
        width: 100%;
      }
    }

    .answer {
      h3 {
        font-size: 1.9rem;
        margin: 2rem 0;
      }
    }
  }
`;
const QuestionDetail = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const question = location.state;
  const getLocalDate = (date) => {
    return new Date(date).toLocaleDateString();
  };

  return (
    <div className="container">
      <StyledQuestion>
        <div className="title">
          <div>
            <h2>{question.title}</h2>
            <BtnBlueFill onClick={() => navigate("/questions/ask")}>
              Ask Question
            </BtnBlueFill>
          </div>
          <div className="info">
            <p>
              Asked <span>{getLocalDate(question.createAt)}</span>
            </p>
            <p>
              Modified <span>{getLocalDate(question.modifiedAt)}</span>
            </p>
            {/* <p>
            Viewed <span>13 times</span>
          </p> */}
          </div>
        </div>
        <div className="content-wrap">
          <div className="mainbar">
            <DetailBody data={question} type="question" />
            <div className="answer">
              <h3>1 Answer</h3>
              <DetailBody data={question} type="comment" />
              <form>
                <h3>Your Answer</h3>
                <Editor />
                <BtnBlueFill>Post Your Answer</BtnBlueFill>
              </form>
            </div>
          </div>
          <Sidebar />
        </div>
      </StyledQuestion>
    </div>
  );
};

export default QuestionDetail;
