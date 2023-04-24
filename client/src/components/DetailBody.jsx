import styled from "styled-components";
import { LinkBlue, BtnBlueFill } from "../styles/common.js";
import Tag from "./tag.jsx";
import userImg from "../assets/user.png";

const StyledDetailBody = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid var(--box-border);

  .vote-box {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0.5em;
    flex: 0 0 5rem;

    .svg-icon {
      fill: var(--input-border);
    }

    .vote-count {
      color: var(--gray);
      font-size: 2.1rem;
    }
  }

  .content {
    width: calc(100% - 7rem);

    .content-body {
      margin-bottom: 2.5rem;
    }

    .content-footer {
      margin: 2.5rem 0;
      display: flex;
      justify-content: space-between;
      color: var(--gray);

      .btns {
        display: flex;
        gap: 0.5em;
      }

      .user-profile {
        background-color: #d0e3f1;
        padding: 1rem;
        width: 200px;
        border-radius: 3px;

        p {
          margin-bottom: 0.5rem;
        }

        > div {
          display: flex;
          align-items: center;
          gap: 0.5em;

          img {
            width: 3.2rem;
            height: 3.2rem;
          }
        }
      }
    }

    .comment-wrap {
      border-top: 1px solid var(--box-border);
      margin-bottom: 2.4rem;

      .comment {
        padding: 0.5em;
        border-bottom: 1px solid var(--hover-gray);

        .date {
          color: var(--gray);
        }
      }

      form {
        margin-top: 1rem;
        display: flex;
        align-items: flex-start;

        textarea {
          border: 1px solid var(--input-border);
          border-radius: 3px;
          flex-grow: 1;
          height: 5rem;
        }

        button {
          flex: 0 0 auto;
        }
      }
    }
  }
`;

const DetailBody = () => {
  return (
    <StyledDetailBody>
      <div className="vote-box">
        <button type="button" className="btn-vote-up">
          <svg
            aria-hidden="true"
            className="svg-icon iconArrowUpLg"
            width="36"
            height="36"
            viewBox="0 0 36 36"
          >
            <path d="M2 25h32L18 9 2 25Z"></path>
          </svg>
        </button>
        <p className="vote-count">0</p>
        <button type="button" className="btn-vote-down">
          <svg
            aria-hidden="true"
            className="svg-icon iconArrowDownLg"
            width="36"
            height="36"
            viewBox="0 0 36 36"
          >
            <path d="M2 11h32L18 27 2 11Z"></path>
          </svg>
        </button>
      </div>
      <div className="content">
        <div className="content-body">본문 내용~~~~~~</div>
        <Tag />
        <div className="content-footer">
          <div className="btns">
            <a href="/">Share</a>
            <a href="/">Edit</a>
            <a href="/">Follow</a>
          </div>
          <div className="user-profile">
            <p>asked 20 mins ago</p>
            <div>
              <img src={userImg} alt="user profile img" />
              <LinkBlue as="span">Username</LinkBlue>
            </div>
          </div>
        </div>
        <div className="comment-wrap">
          <div className="comment">
            comment~~~~~ - <LinkBlue as="span">username</LinkBlue>{" "}
            <span className="date">30 mins ago</span>
          </div>
          <form>
            <textarea />
            <BtnBlueFill>Add comment</BtnBlueFill>
          </form>
        </div>
      </div>
    </StyledDetailBody>
  );
};

export default DetailBody;
