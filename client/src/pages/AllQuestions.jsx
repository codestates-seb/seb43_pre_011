import styled from "styled-components";
import Sidebar from "../components/Sidebar.jsx";
import Filter from "../components/Filter.jsx";
import { BtnBlueFill } from "../styles/common.js";
import BREAKPOINT from "../breakpoint.js";
import Paging from "../components/Paging.jsx";
import Question from "../components/question.jsx";
import { NavLink } from "react-router-dom";

const StyledQuestions = styled.div`
  width: calc(100% - 32.4rem);

  @media screen and (max-width: ${BREAKPOINT.tablet}) {
    width: 100%;
  }

  .page-header {
    padding-left: 2.4rem;
    border-bottom: 1px solid var(--box-border);
    > div {
      display: flex;
      justify-content: space-between;
      margin-bottom: 1.2rem;

      &:first-of-type {
        margin-bottom: 2.5rem;
      }
    }

    h2 {
      font-size: 2.7rem;
    }

    .count {
      font-size: 1.7rem;
    }
  }
`;
const AllQuestions = ({ questions }) => {
  return (
    <div className="container">
      <StyledQuestions>
        <div className="page-header">
          <div>
            <h2>All Questions</h2>
            <NavLink to="/questions/ask" className="btn-ask">
              <BtnBlueFill>Ask Question</BtnBlueFill>
            </NavLink>
          </div>
          <div>
            <p className="count">{questions.length} questions</p>
            <Filter />
          </div>
        </div>
        <ul className="questions-list">
          {questions.map((question) => (
            <Question key={question.questionId} question={question} />
          ))}
        </ul>
        <Paging />
      </StyledQuestions>
      <Sidebar />
    </div>
  );
};

export default AllQuestions;
