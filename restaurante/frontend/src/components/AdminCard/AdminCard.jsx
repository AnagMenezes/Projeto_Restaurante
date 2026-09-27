import './AdminCard.css'

function AdminCard({ titulo, descricao }) {
  return (
    <div className="admin-card">
      <h2>{titulo}</h2>
      <p>{descricao}</p>
    </div>
  )
}

export default AdminCard