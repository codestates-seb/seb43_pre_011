import styled from "styled-components";

export const Input = styled.div`
  display: flex;
  flex-direction: column;

  width: 316px;
  margin-bottom: 36px;
  padding: 24px 0 24px 24px;

  background-color: white;
  box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);
  border-radius: 5px;

  .container {
    margin-top: 12px;
  }
  .title {
    padding: 0 2px 8px 2px;
    font-size: 15px;
    font-weight: 600;
    .svg-icon {
      position: relative;
      top: 5px;
      left: -27px;
      right: 5px;
      fill: rgb(208, 50, 56);
    }
    .input {
      width: 268px;
      height: 32.2569px;
      margin-top: 8px;
      padding: 8px 9px 8px 9px;
      border-radius: 3px;
      border: 1px solid var(--input-border);
      outline: none;

      &:focus {
        border-color: var(--light-blue);
        box-shadow: 0 0 0 0.4rem #0074cc26;
      }
    }
    .error {
      border: 1px solid hsl(357.7, 62.7%, 50.6%);
      &:focus {
        border-color: rgb(208, 50, 56);
        box-shadow: 0 0 0 0.4rem rgb(255, 216, 217);
      }
    }
    .message {
      display: inline-block;
      width: 268px;
      padding: 8px 0 8px 0;
      font-size: 12px;
      font-weight: 400;
      color: var(--gray);
    }
    .error-message {
      display: inline-block;
      width: 268px;
      padding: 8px 0 8px 0;
      font-size: 12px;
      font-weight: 400;
      color: hsl(357.7, 62.7%, 50.6%);
    }
  }
`;
