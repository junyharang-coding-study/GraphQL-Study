import './components.css';
import {useState} from "react";
import {useQuery, useMutation, gql} from "@apollo/client";

const SAVE_TEAM = gql`
    mutation saveTeam($input: TeamRequestDto!) {
        saveTeam(input: $input) {
            statusCode,
            message,
            data
        }
    }
`;

const GET_TEAMS = gql`
    query getTeamAndMembersByTeamIdOrNothing {
        getTeamAndMembersByTeamIdOrNothing {
            statusCode,
            message,
            data {
                teamId,
                manager,
                members {
                    teamId,
                    lastName,
                    firstName,
                    role,
                }
            }
        }
    }
`;

const GET_TEAM = gql`
    query getTeam($teamId: ID!) {
        getTeam(teamId: $teamId) {
            statusCode,
            message,
            data {
                teamId,
                manager,
                office,
                extensionNumber,
                mascot,
                cleaningDuty,
                project,
            }
        }
    }
`;

const UPDATE_TEAM = gql`
    mutation updateTeam($teamId: ID!, $input: TeamUpdateRequestDto) {
        updateTeam(teamId: $teamId, input: $input) {
            statusCode,
            message,
            data
        }
    }
`;

const DELETE_TEAM = gql`
    mutation deleteTeam($teamId: ID!) {
        deleteTeam(teamId: $teamId) {
            statusCode,
            message,
            data
        }
    }
`;

let reFetchTeamInfo;

function Teams() {

    const [contentId, setContentId] = useState(0)
    const [inputs, setInputs] = useState({
        manager: "",
        office: "",
        extensionNumber: "",
        mascot: "",
        cleaningDuty: "",
        project: ""
    })

    function AsideItems() {

        const roleIcons = {
            developer: "💻",
            designer: "🎨",
            planner: "📝",
        }

        const {loading, error, data, refetch} = useQuery(GET_TEAMS);
        reFetchTeamInfo = refetch;

        if (loading) {
            return <p className="loading">로딩 중이에요! 😤</p>
        }

        if (error || data.getTeamAndMembersByTeamIdOrNothing.statusCode !== 200) {
            return <p className="error">Error가 발생했어요! 🫢</p>
        }

        return (
            <ul>
                {data.getTeamAndMembersByTeamIdOrNothing.data.map(({teamId, manager, members}) => {
                    return (
                        <li key={teamId}>
                            <span className="teamItemTitle" onClick={() => {
                                setContentId(teamId)
                            }}>
                                Team {teamId} : {manager}'s
                            </span>

                            <ul className="teamMembers">
                                {members.map(({member_teamId, firstName, lastName, role}) => {
                                    return (
                                        <li key={member_teamId}>
                                            {roleIcons[role]} {firstName} {lastName}
                                        </li>
                                    )
                                })}
                            </ul>
                        </li>
                    )
                })}
            </ul>
        )
    }

    function MainContents() {

        const {loading, error} = useQuery(GET_TEAM, {
            variables: {teamId: contentId}, onCompleted: (data) => {
                if (contentId === 0) {
                    setInputs({
                        manager: "",
                        office: "",
                        extensionNumber: "",
                        mascot: "",
                        cleaningDuty: "",
                        project: ""
                    })
                } else {
                    setInputs({
                        manager: data.getTeam.data.manager,
                        office: data.getTeam.data.office,
                        extensionNumber: data.getTeam.data.extensionNumber,
                        mascot: data.getTeam.data.mascot,
                        cleaningDuty: data.getTeam.data.cleaningDuty,
                        project: data.getTeam.data.project
                    })
                }
            }
        });

        if (loading) {
            return <p className="loading">로딩 중이에요! 😤</p>
        }

        if (error) {
            return <p className="error">Error가 발생했어요! 🫢</p>
        }

        function handleChange(team) {
            const {name, value} = team.target
            setInputs({
                ...inputs,
                [name]: value
            })
        }

        return (
            <div className="inputContainer">
                <table>
                    <tbody>
                    {contentId !== 0 && (
                        <tr>
                            <td>teamId</td>
                            <td>{contentId}</td>
                        </tr>
                    )}

                    <tr>
                        <td>관리자</td>
                        <td>
                            <input type="text" name="manager" value={inputs.manager} onChange={handleChange}/>
                        </td>
                    </tr>

                    <tr>
                        <td>사무실 호수</td>
                        <td>
                            <input type="text" name="office" value={inputs.office} onChange={handleChange}/>
                        </td>
                    </tr>

                    <tr>
                        <td>내선 번호</td>
                        <td>
                            <input type="text" name="extensionNumber" value={inputs.extensionNumber}
                                   onChange={handleChange}/>
                        </td>
                    </tr>

                    <tr>
                        <td>마스코트</td>
                        <td>
                            <input type="text" name="mascot" value={inputs.mascot} onChange={handleChange}/>
                        </td>
                    </tr>

                    <tr>
                        <td>청소 당번 요일</td>
                        <td>
                            <input type="text" name="cleaningDuty" value={inputs.cleaningDuty} onChange={handleChange}/>
                        </td>
                    </tr>

                    <tr>
                        <td>담당 프로젝트</td>
                        <td>
                            <input type="text" name="project" value={inputs.project} onChange={handleChange}/>
                        </td>
                    </tr>
                    </tbody>
                </table>

                {contentId === 0 ? (
                    <div className="buttons">
                        <button onClick={() => {
                            execSaveTeam()
                        }}>등록
                        </button>
                    </div>
                ) : (
                    <div className="buttons">
                        <button onClick={() => {
                            execUpdateTeam()
                        }}>수정
                        </button>
                        <button onClick={() => {
                            execDeleteTeam()
                        }}>삭제
                        </button>
                        <button onClick={() => {
                            setContentId(0)
                        }}>New
                        </button>
                    </div>
                )}
            </div>
        )
    }

    function execSaveTeam() {
        saveTeam({variables: {input: inputs}});
    }

    const [saveTeam] = useMutation(SAVE_TEAM, {onCompleted: saveTeamCompleted});

    function saveTeamCompleted(data) {
        console.log(`${JSON.stringify(data.saveTeam)} 등록 완료 하였어요. 😀`);
        alert(`팀 번호 : ${data.saveTeam.data} 항목이 등록되었습니다.  😀`);
        reFetchTeamInfo();
        setContentId(0);
    }

    function execUpdateTeam() {
        updateTeam({
            variables: {
                teamId: contentId,
                input: inputs
            }
        })
    }

    const [updateTeam] = useMutation(UPDATE_TEAM, {onCompleted: updateTeamCompleted});

    function updateTeamCompleted(data) {
        console.log(`${JSON.stringify(data.updateTeam)} 수정 완료 하였어요. 😀`);
        alert(`팀 번호 : ${data.updateTeam.data} 항목이 수정되었습니다.  😀`);
        reFetchTeamInfo()
    }

    function execDeleteTeam() {
        if (window.confirm("해당 팀을 정말 삭제하실거에요? 😮")) {
            deleteTeam({variables: {teamId: contentId}});
        }
    }

    const [deleteTeam] = useMutation(DELETE_TEAM, {onCompleted: deleteTeamCompleted});

    function deleteTeamCompleted(data) {
        console.log(`${JSON.stringify(data.deleteTeam)} 삭제 완료 하였어요. 😨`);
        alert(`팀 번호 : ${data.deleteTeam.data} 항목이 삭제되었습니다.  😨`);
        reFetchTeamInfo();
        setContentId(0);
    }

    return (
        <div id="teams" className="component">
            <aside>
                {AsideItems()}
            </aside>
            <section className="contents">
                {MainContents()}
            </section>
        </div>
    )
}

export default Teams;