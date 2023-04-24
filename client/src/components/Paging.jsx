import styled from "styled-components";

const StyledPaging = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 0.4rem;
  margin: 2rem 0;
  padding-left: 2.4rem;

  a {
    display: block;
    border: 1px solid var(--input-border);
    border-radius: 3px;
    padding: 0.8rem;

    &:hover {
      background-color: var(--box-border);
    }

    &.active {
      color: var(--white);
      background-color: var(--orange);
      border-color: var(--orange);
    }
  }
`;

const Paging = () => {
  return (
    <StyledPaging>
      <a href="/" className="prev">
        Prev
      </a>
      <a href="/" className="active">
        1
      </a>
      <a href="/">2</a>
      <a href="/">3</a>
      <a href="/" className="next">
        Next
      </a>
    </StyledPaging>
  );
};

export default Paging;
