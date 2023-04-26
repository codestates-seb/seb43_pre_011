import Tag from "./tag.jsx";
import { LinkBlue } from "../styles/common.js";
import userImg from "../assets/user.png";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { useRecoilValue } from "recoil";
import { getMembersSelector } from "../store/index.js";

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
    flex-grow: 1;

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

const Question = ({ question }) => {
  const navigate = useNavigate();
  const members = useRecoilValue(getMembersSelector);
  // const nickname = members.filter((el) => el.memberId === question.memberId)[0]
  //   .nickName;
  const getLocalDate = (createAt) => {
    return new Date(createAt).toLocaleDateString();
  };

  return (
    <StyledQuestion>
      <div className="stats">
        <p>{question.votecount} votes</p>
        <p>0 answers</p>
        {/* <p>0 views</p> */}
      </div>
      <div className="content">
        <div className="title">
          <h3>
            <LinkBlue
              onClick={() => {
                navigate(`questions/${question.questionId}`, {
                  state: question,
                });
              }}
            >
              {question.title}
            </LinkBlue>
          </h3>
          <p>{question.body}</p>
        </div>
        <div className="info">
          <Tag tags={["javascript"]} />
          {/* <Tag tags={question.tags} /> */}
          <div className="profile">
            <img className="profile-img" src={userImg} alt="user profile img" />
            <LinkBlue as="span">{members[0].nickName}</LinkBlue>
            {getLocalDate(question.createAt)}
          </div>
        </div>
      </div>
    </StyledQuestion>
  );
};

export default Question;
