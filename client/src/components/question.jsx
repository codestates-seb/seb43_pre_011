import Tag from "../components/tag.jsx";
import { LinkBlue } from "../styles/common.js";
import favicons from "../assets/favicons-sprite32.png";
import styled from "styled-components";

const StyledQuestion = styled.li`
  display: flex;
  padding: 1.6rem 1.6rem 1.6rem 2.4rem;
  border-bottom: 1px solid var(--box-border);

  .stats {
    display: flex;
    flex-direction: column;
    gap: 0.6rem;
    flex-basis: 11rem;
    color: var(--gray);

    p:first-of-type {
      color: var(--black);
    }
  }

  .content {
    display: flex;
    flex-direction: column;
    line-height: 1.3em;
    word-break: break-word;
    hyphens: auto;
    margin-bottom: 1.3rem;

    h3 {
      font-size: 1.7rem;
      margin-bottom: 0.5rem;
    }

    p {
      margin-bottom: 0.8rem;
    }

    .info {
      display: flex;
      justify-content: space-between;

      .profile {
        align-self: center;
        display: flex;
        gap: 0.5rem;
        color: var(--gray);
        .profile-img {
          display: block;
          width: 1.6rem;
          height: 1.6rem;
          background: url(${favicons}) no-repeat 0 0;
          background-size: 1.6rem;
        }

        strong {
          font-weight: 700;
        }
      }
    }
  }
`;

const Question = () => {
  // 임시
  const tags = ["javascript", "css"];
  return (
    <StyledQuestion>
      <div className="stats">
        <p>0 votes</p>
        <p>0 answers</p>
        <p>0 views</p>
      </div>
      <div className="content">
        <div className="title">
          <h3>
            <LinkBlue href="/">
              why changing fillStyle in canvas 2D changes the color of
              previously drawn rectangles?
            </LinkBlue>
          </h3>
          <p>
            I have following code that first draws 3 small yellow rectangles and
            them draws a big blue one. I change fillStyle property before the
            last drawing. As a result, all rectangles are blue. If The something
          </p>
        </div>
        <div className="info">
          <Tag tags={tags} />
          <div className="profile">
            <span className="profile-img"></span>
            <LinkBlue as="span">username</LinkBlue>
            <strong>659</strong>
            asked 10 mins ago
          </div>
        </div>
      </div>
    </StyledQuestion>
  );
};

export default Question;
