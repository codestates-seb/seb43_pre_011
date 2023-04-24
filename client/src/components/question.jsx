import Tag from "./tag.jsx";
import { LinkBlue } from "../styles/common.js";
import userImg from "../assets/user.png";
import styled from "styled-components";

const StyledQuestion = styled.li`
  display: flex;
  padding: 1.6rem 1.6rem 1.6rem 2.4rem;
  border-bottom: 1px solid var(--box-border);

  .stats {
    display: flex;
    flex-direction: column;
    gap: 0.6rem;
    flex: 0 0 7rem;
    color: var(--gray);

    p:first-of-type {
      color: var(--black);
    }
  }

  .content {
    display: flex;
    flex-direction: column;
    line-height: 1.3em;
    margin-bottom: 1.3rem;
    flex-shrink: 1;

    h3 {
      font-size: 1.7rem;
      margin-bottom: 0.5rem;
      word-break: break-word;
      hyphens: auto;
      overflow-wrap: break-word;
      overflow: hidden;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }

    p {
      margin-bottom: 0.8rem;
      word-break: break-word;
      hyphens: auto;
      overflow-wrap: break-word;
      overflow: hidden;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
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
            <img className="profile-img" src={userImg} alt="user profile img" />
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
